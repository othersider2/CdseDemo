package com.cdse.domain;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.persistence.JoinColumn;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PERSON")
public class Person implements CdseEntity{
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public MultipartFile getPhotoPart() {
		return photoPart;
	}
	public void setPhotoPart(MultipartFile photoPart) {
		this.photoPart = photoPart;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	   
	@Id
	@Column(name = "PERSON_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer personId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Transient
	private MultipartFile photoPart;
	
	@Column(name = "PHOTO")
	private Blob photo;

	@Transient
	private EntityState state;
	
	@Transient
	private String personIdString;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PERSON_ROLE", joinColumns = { 
			@JoinColumn(name = "PERSON_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", 
					nullable = false, updatable = false) })
    private Set<Role> roles = new HashSet<Role>();
    
	@Override
	public void populate() throws IOException {
        InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
        if (this.getPhotoPart() != null) {
            // prints out some information for debugging
            System.out.println(this.getPhotoPart().getName());
            System.out.println(this.getPhotoPart().getSize());
            System.out.println(this.getPhotoPart().getContentType());
             
            // obtains input stream of the upload file
            inputStream = this.getPhotoPart().getInputStream();
        }
         
        byte[] bFile = new byte[(int) this.getPhotoPart().getSize()];
        inputStream.read(bFile);
        
        try {
        	this.setPhoto(new SerialBlob(bFile));
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        switch (getState()) {
        	
        case NEW:
        	break;        	
        case OLD:
        	break;   	
        case DIRTY:
        	break;
        default:
        	break;
        }
        
	}
	public EntityState getState() {
		return state;
	}
	@Override
	public void setState(EntityState state) {
		this.state = state;
	}
	@Override
	public <T> void copy(T inEntity) {
		Person inPerson = (Person)inEntity;
		this.setFirstName(inPerson.getFirstName());
		this.setLastName(inPerson.getLastName());
		this.setPhotoPart(inPerson.getPhotoPart());
		this.setRoles(inPerson.getRoles());
	}
	@Override
	public int getId() {
		return getPersonId();
	}
	public String getPersonIdString() {
		return personIdString;
	}
	public void setPersonIdString(String personIdString) {
		this.personIdString = personIdString;
        this.setPersonId(Integer.parseInt(personIdString));
	}

}
