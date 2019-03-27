package com.example.Osoitemuistio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	public class Yhteystieto {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		//@ManyToOne
		//@JsonIgnore
		//@JoinColumn(name = "id")
		
		private Long id;
		private String etunimi;
		private String sukunimi;
		private String katuos;
		private String postinro;
		private String kaupunki;
		private String puhelin;
		
		public Yhteystieto() {}

		public Yhteystieto(String etunimi, String sukunimi, String katuos, String postinro, String kaupunki, String puhelin) {
			this.etunimi = etunimi;
			this.sukunimi =sukunimi;
			this.katuos = katuos;
			this.postinro = postinro;
			this.kaupunki = kaupunki;
			this.puhelin = puhelin;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEtunimi() {
			return etunimi;
		}

		public void setEtunimi(String etunimi) {
			this.etunimi = etunimi;
		}

		public String getSukunimi() {
			return sukunimi;
		}

		public void setSukunimi(String sukunimi) {
			this.sukunimi = sukunimi;
		}

		public String getKatuos() {
			return katuos;
		}

		public void setKatuos(String katuos) {
			this.katuos = katuos;
		}
		
		public String getPostinro() {
			return postinro;
		}

		public void setPostinro(String postinro) {
			this.postinro = postinro;
		}

		public String getKaupunki() {
			return kaupunki;
		}

		public void setKaupunki(String kaupunki) {
			this.kaupunki = kaupunki;
		}
		public String getPuhelin() {
			return puhelin;
		}

		public void setPuhelin(String puhelin) {
			this.puhelin = puhelin;
		
		}
		
		@Override
		public String toString() {
			return "Yhteystieto [id=" + id + ", nimi=" + etunimi + " " + sukunimi + ", osoite=" + katuos + ", " + postinro + " " + kaupunki + ", puhelinnumero=" + puhelin + "]";
		}
	}
