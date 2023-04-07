package com.gym2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gym2.members_program.Member;
import com.gym2.members_program.Program;
import com.gym2.repository.MemberRepository;
import com.gym2.repository.ProgramRepository;

@Controller
public class ProgramController {
	@Autowired
	private ProgramRepository repo;
	
	
	public ProgramController(ProgramRepository repo) {
		this.repo = repo;
	}
	
	
	/*
	 * display all Programs of Gym
	 * */
	@GetMapping("/members/showAllPrograms")
	public String getAllPrograms(Model model) {
		
		List<Program> programs = this.repo.findAll();
		model.addAttribute("Programs",programs);
		return "showAllPrograms";
	}
	
	@GetMapping("/members/addprogram")
	public String addProgram(Model model) {
		Program newProgram = new Program();
		model.addAttribute("program",newProgram);
		return "addprogram";
	}
	

	@RequestMapping("/members/save2")
	public String saveProgram(@ModelAttribute("program") Program newProgram, Model theModel) {
		//this.memberRepository.save(newMember);
		this.repo.save(newProgram);
		
		return "redirect:/members/showAllPrograms";
	}
	

	@RequestMapping("/members/delete2")
	public String deleteMember(@RequestParam("programId") int theId) {
		this.repo.deleteById(theId);
		//List<Member> members = this.memberRepository.findAll();
		//model.addAttribute("Members",members);
		return "redirect:/members/showAllPrograms";
	}
	
	/*
	 * update alla me ta stoixeia tou sto add...
	 * */
	/*@RequestMapping("/members/updateprogram")
	public String updateProgramPrice(@RequestParam("programId") int theId, Model model) {
		model.addAttribute("program",this.repo.findById(theId));
		
		return "addprogram";
	}*/
	@RequestMapping("/members/updateprogram")
	public String updateProgramPrice(@RequestParam("programId") int theId, Model model) {
		
		model.addAttribute("program",this.repo.findById(theId));
		return "addprogram";
	}
}