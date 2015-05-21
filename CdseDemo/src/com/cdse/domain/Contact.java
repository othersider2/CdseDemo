package com.cdse.domain;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

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
@Table(name="CONTACT")
public class Contact implements CdseEntity{
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
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
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	   
	@Id
	@Column(name = "CONTACT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer contactId;
	
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
	
    @OneToOne(cascade=CascadeType.ALL)  
    @JoinTable(name="CONTACT_ROLE",  
    joinColumns={@JoinColumn(name="CONTACT_ID", referencedColumnName="CONTACT_ID")},  
    inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ROLE_ID")})  
    private Role role;  
    
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
		Contact inContact = (Contact)inEntity;
		this.setFirstName(inContact.getFirstName());
		this.setLastName(inContact.getLastName());
		this.setPhotoPart(inContact.getPhotoPart());
	}

}
