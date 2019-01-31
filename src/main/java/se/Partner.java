package se;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the partner database table.
 * 
 */
@Entity
@NamedQuery(name="Partner.findAll", query="SELECT p FROM Partner p")
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARTNER_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="PARTNER_ID_GENERATOR")
	private int id;

	private String name;

	public Partner() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}