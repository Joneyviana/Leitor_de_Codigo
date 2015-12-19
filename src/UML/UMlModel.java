package UML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.internal.impl.NamedElementImpl;
import org.eclipse.uml2.uml.internal.impl.OperationImpl;


import engenharia_reversa.process.Element;
import engenharia_reversa.process.Entity;
import engenharia_reversa.process.Operation;
import engenharia_reversa.process.Attribute;
public class UMlModel {

private UmlHandlefile uml;
private EObject classe;
private Element association;
private ArrayList<Entity> entities = new ArrayList<>();
private InputStream stream;
private File outputFile;
public UMlModel(String  filename , IFile file){
	outputFile = new File(filename) ;
	uml = new UmlHandlefile(outputFile , file) ;
	uml.init();
}

public void addEntity(Entity entity){
	if (entity.hasname()){
	 String name = entity.getName();  
	 entities.add(entity);
	classe = uml.addclasse(name);
	Operation operation = entity.getOperation();
	Attribute attribute = entity.getAtribute();
	
	add_operations(operation);
    //add_attributes(attribute);	
    
    if(entity.hasSuperClass())
    uml.addGeneration(classe, entity.getSuperclasse());
}}

public void create_Attributes(){
	for(EObject current_class :uml.classes){
		
		for(Entity current_entity:entities){
		 if(((Class)current_class).getName().equals(current_entity.getName())){
			 while(current_entity.getAtribute().find()){
				 add_Attributes(current_entity.getAtribute(),current_class ) ;
				 
			 }break;
		 }
	
		}}
        
}

public void add_Attributes(Attribute association , EObject classe_has_association) {
	    Association assoc = null;
	    for(Entity entity : entities){
	    	 
	    	if (entity.getName().equals(association.gettype())){
	    	 assoc = uml.addAssociation(((Class) classe_has_association), association.gettype());
	         uml.save();
	    	 break;
	    	}}
		if( assoc == null){
			add_attributes_without_association(association,((Class) classe_has_association) );
		}
	}

public ParameterUml listarparameters(Operation operation){
	EList<String> names = new BasicEList<String>();
	EList<Type> types = new BasicEList<Type>();
	Attribute parameter = operation.getParameter() ;
    ParameterUml parameterUML = new ParameterUml();
    if(parameter!=null){
        while(parameter.find()){
        	
        	names.add(parameter.getname());
    	   types.add(uml.handletype(parameter.gettype()));
    }}
    parameterUML.names = names ;
    parameterUML.types = types ;
    return parameterUML ;
}

private void add_operations(Operation operation){
	while(operation.find()){
		
		ParameterUml parameterUML = listarparameters(operation);
	   OperationImpl operationUml = (OperationImpl) ((Class) classe).createOwnedOperation(operation.getname(),parameterUML .names , parameterUML.types, null);
	   operationUml.setVisibility(uml.getVisibility(operation.getvisibility()));
	   uml.save();
}
	
}
private void add_attributes_without_association(Attribute attribute , Class classe){
	
		
		Property attributeUml = classe.createOwnedAttribute(attribute.getname(), uml.handletype(attribute.gettype()));
		 attributeUml.setVisibility(uml.getVisibility(attribute.getvisibility()));
		   uml.save(); 
		}
	
public void refresh(IFile file) throws IOException, CoreException{
	stream = uml.openContentStream();
	file.setContents(stream,true, true, null);
}
}
