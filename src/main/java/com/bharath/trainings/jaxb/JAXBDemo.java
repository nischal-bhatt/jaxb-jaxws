package com.bharath.trainings.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JAXBDemo {

	public static void main(String[] args) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
		    Marshaller marshaller = context.createMarshaller();
		    Patient patient = new Patient();
		    patient.setId(123);
		    patient.setName("maalaa");
		    
		    StringWriter writer = new StringWriter();
		    
		    marshaller.marshal(patient, writer);
		    
		    System.out.println(writer.toString());
		    
		    
		    Unmarshaller unmarshaller = context.createUnmarshaller();
		    String tobeunmarshalled = writer.toString();
		   Patient patientResult  = (Patient)unmarshaller.unmarshal(new StringReader(tobeunmarshalled));
		    
		   System.out.println(patientResult.getName());
		   
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
