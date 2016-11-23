package pe.upeu.sistemas;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class SpringMongoConfig {

	public static void main(String[] args){
		ApplicationContext ctx = new GenericXmlApplicationContext("pe/upeu/sistemas/SpringConfig.xml");
		MongoOperations mongoOperations = (MongoOperations)ctx.getBean("mongoTemplate");
		
		System.out.println(" lel : " + mongoOperations);
		Grades grade= new Grades();
		grade.setStudent_id(1);
		grade.setType("Task");
		grade.setScore(40.50);
		mongoOperations.insert(grade);
		
		List<Grades> list = mongoOperations.findAll(Grades.class);
		System.out.println(list.size());
		for(int i=0; i < 10; i++){
			Grades g = list.get(i);
			System.out.println(g.getId()+"-"+g.getStudent_id()+"-"+g.getType());
		}
	}
	
}
