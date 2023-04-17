package com.digitar120.registro.model;

import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Register {
	
	private @Id @GeneratedValue Integer id;
	private String texto;
	
	public Register() {}
	
	public Register(String texto) {
		this.texto = texto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Register))
	      return false;
	    Register registro = (Register) o;
	    return Objects.equals(this.id, registro.id) && Objects.equals(this.texto, registro.texto);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.texto);
	  }

	  @Override
	  public String toString() {
	    return "Registro{" + "id=" + this.id + ", texto='" + this.texto + '\'' + '}';
	  }
	
	
}
