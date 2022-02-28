package com.prashant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.prashant.DAO.ConverterDAO;
import com.prashant.model.ConverterModel;
import com.prashant.model.ResponseModel;

@RestController
public class MainController {

	@Autowired
	ConverterDAO converterDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/converter", method = RequestMethod.GET)
	public ModelAndView converter(ModelAndView mnv) {
		mnv.setViewName("converter");
		mnv.addObject("converterModel", converterDAO.getConverterModel());
		return mnv;
	}

	@RequestMapping(value = "/convert", method = RequestMethod.POST)
	public ResponseEntity<ResponseModel> doConvert(@ModelAttribute ConverterModel cModel, Model model,
			HttpServletRequest request) {

		HttpStatus status = HttpStatus.OK;

		model.addAttribute("converterModel", cModel);

		ResponseModel rm = converterDAO.getConvertedValue(cModel.getSrcCurrency(), cModel.getTgtCurrency(),
				cModel.getSrcAmount());

		return new ResponseEntity<ResponseModel>(rm, status);
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact() {
		return new ModelAndView("contact");
	}
}
