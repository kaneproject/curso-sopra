package com.sopra.spring.anotaciones.model.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.spring.anotaciones.model.dao.FacturasDao;
import com.sopra.spring.anotaciones.model.entities.Factura;

@Service
public class GestionFacturas {
	
	@Autowired
	private FacturasDao facturasDao;
	
	public boolean guardarFactura(Factura factura) {
		return facturasDao.addFactura(factura);
	}

	public List<Factura> dameTodasLasFacturas(){
		return facturasDao.getFacturas();
	}
	
	public FacturasDao getFacturasDao() {
		return facturasDao;
	}

	public void setFacturasDao(FacturasDao facturasDao) {
		this.facturasDao = facturasDao;
	}
	
}
