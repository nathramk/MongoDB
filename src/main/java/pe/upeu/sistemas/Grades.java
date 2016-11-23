package pe.upeu.sistemas;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="grades")
public class Grades {

	@Id
	private String id;
	private int student_id;
	private String type;
	private double score;
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int stiden_id) {
		this.student_id = stiden_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
