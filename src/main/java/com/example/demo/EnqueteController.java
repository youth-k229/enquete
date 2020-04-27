package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(types=EnqueteForm.class)
public class EnqueteController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mv){
		EnqueteForm form = new EnqueteForm();
		mv.addObject(form);
		mv.setViewName("zero");
		return mv;
	}

	@RequestMapping(value="/goToOne",method=RequestMethod.GET)
	public ModelAndView one(ModelAndView mv,EnqueteForm form){
		mv.setViewName("one");
		return mv;
	}

	@RequestMapping(value="/goToTwo",method=RequestMethod.POST)
	public ModelAndView two(ModelAndView mv,EnqueteForm form,
			@RequestParam("food")String food){
		form.setFood(food);
		mv.setViewName("two");
		return mv;
	}

	@RequestMapping(value="/goToThree",method=RequestMethod.POST)
	public ModelAndView three(ModelAndView mv,EnqueteForm form,
			@RequestParam("animal")String animal){
		form.setAnimal(animal);
		mv.setViewName("three");
		return mv;
	}

	@RequestMapping(value="/goToResult",method=RequestMethod.POST)
	public ModelAndView result(ModelAndView mv,EnqueteForm form,
			@RequestParam("sports")String sports){
		form.setSports(sports);
		String food = form.getFood();
		String animal = form.getAnimal();
		mv.addObject("food",food);
		mv.addObject("animal",animal);
		mv.addObject("sports",sports);
		mv.setViewName("result");
		return mv;
	}


}
