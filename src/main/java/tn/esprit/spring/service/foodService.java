package tn.esprit.spring.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.FoodCalories;
import tn.esprit.spring.entity.MedicalRec;
import tn.esprit.spring.entity.callories;
import tn.esprit.spring.entity.foodmedrecwithgramage;
import tn.esprit.spring.repository.ChildRepository;
import tn.esprit.spring.repository.FoodmedrecwithgramageRepository;
import tn.esprit.spring.repository.foodRepository;


@Service
public class foodService implements IfoodService {
	@Autowired
	ChildRepository child;
	@Autowired
	foodRepository food;
	
	 @Autowired
	 FoodmedrecwithgramageRepository foodgrammage;
	
	public void affectmedicalrectofood(int idkinder,long idfood) throws ParseException{
		List<MedicalRec> medicals=child.getAllmedicalrecdbykindergartene(idkinder);
		
		FoodCalories onefood=food.findById(idfood);
		
		foodmedrecwithgramage fb=new foodmedrecwithgramage();
		for(MedicalRec onemed:medicals){
			
			
		     long idofmenucategory=onemed.getMenucategory().getId();
		    
		     
		     callories cal=onemed.getCallories();
		     float vluecaloriesofonemed=cal.getValue();
	          float valueofcaloryofonefood=(float)Float.parseFloat(onefood.getValue());
		     
		     float xvalue=vluecaloriesofonemed/valueofcaloryofonefood;
			//date
			Date date = new Date();
	           String strDateFormat = "yyyy-MM-dd hh:mm:ss";
	           DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	           String formattedDate= dateFormat.format(date);
	           Date date1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(formattedDate);
	           
	           if(idofmenucategory==1){
	        	   if( xvalue==1)
		        	{
		        	fb.setFoodsandtheircallories(onefood);
		        	fb.setGramsneeded(10+100);
		        	fb.setMedicalRec(onemed);
		        	fb.setPublishedDate(date1);
		        	foodgrammage.save(fb);	
		        	} 
	        	   else if(xvalue < 1)   //n9es
		           {
		        	   fb.setFoodsandtheircallories(onefood);
			        	fb.setGramsneeded(100/xvalue+10);
			        	fb.setMedicalRec(onemed);
			        	fb.setPublishedDate(date1);
			        	foodgrammage.save(fb);	
		        	   
		           }
		           else if(xvalue >1) //zied
		           {
		        	   fb.setFoodsandtheircallories(onefood);
			        	fb.setGramsneeded(100*xvalue+10);
			        	fb.setMedicalRec(onemed);
			        	fb.setPublishedDate(date1);
			        	foodgrammage.save(fb);	
		        	   
		           }
		           }
		           else if (idofmenucategory ==2)
		           {
		        	   if( xvalue==1)
			        	{
			        	fb.setFoodsandtheircallories(onefood);
			        	fb.setGramsneeded(100-10);
			        	fb.setMedicalRec(onemed);
			        	fb.setPublishedDate(date1);
			        	foodgrammage.save(fb);	
			        	}   
			         
			           else if(xvalue < 1)
			           {
			        	   fb.setFoodsandtheircallories(onefood);
				        	fb.setGramsneeded(100/xvalue-10);
				        	fb.setMedicalRec(onemed);
				        	fb.setPublishedDate(date1);
				        	foodgrammage.save(fb);	
			        	   
			           }
			           else if(xvalue >1)
			           {
			        	   fb.setFoodsandtheircallories(onefood);
				        	fb.setGramsneeded(100*xvalue-10);
				        	fb.setMedicalRec(onemed);
				        	fb.setPublishedDate(date1);
				        	foodgrammage.save(fb);	
			        	   
			           } 
		           }
		           else if (idofmenucategory ==3)
		           {
		        	   if( xvalue==1)
			        	{
			        	fb.setFoodsandtheircallories(onefood);
			        	fb.setGramsneeded(100);
			        	fb.setMedicalRec(onemed);
			        	fb.setPublishedDate(date1);
			        	foodgrammage.save(fb);	
			        	}   
			           else if(xvalue < 1)
			           {
			        	   fb.setFoodsandtheircallories(onefood);
				        	fb.setGramsneeded(100/xvalue);
				        	fb.setMedicalRec(onemed);
				        	fb.setPublishedDate(date1);
				        	foodgrammage.save(fb);	   
			           }
			           else if(xvalue >1)
			           {
			        	   fb.setFoodsandtheircallories(onefood);
				        	fb.setGramsneeded(100*xvalue);
				        	fb.setMedicalRec(onemed);
				        	fb.setPublishedDate(date1);
				        	foodgrammage.save(fb);	   
			           } 
		           }      
			}	
		}
	}

