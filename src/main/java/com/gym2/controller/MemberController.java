package com.gym2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gym2.members_program.Member;
import com.gym2.members_program.Program;
import com.gym2.repository.MemberRepository;
import com.gym2.repository.ProgramRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

/*1. page -? /members/list
 * to RequestMapping me paei sth selida p t lew egw
 *  to return einai gia to HTML 
 *  */


//@RestController
//@RequestMapping
@Controller
public class MemberController {
	
	@Autowired
	private final MemberRepository memberRepository;
	
	@Autowired
	private ProgramRepository programRepository;
	

	public MemberController(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@GetMapping("/members")
	public String getSom(Model model) {
		model.addAttribute("something","'NO PAIN NO GAIN'");
		return("member");
	}
	/* 
	 * Add Member to db
	 *    
	 * */
	@GetMapping("/members/addmember")
	public String addMember(Model model) {
		//List<Member> members = this.memberRepository.findAll();
		Member newMember = new Member();
		List<Program> programs = this.programRepository.findAll();
		//programs.add(0, null); // Add a null program option at the beginning
		model.addAttribute("member",newMember);
		model.addAttribute("programs",programs);
		return "addmember";
	}
	//@RequestMapping("/members/dele")
	@RequestMapping("/members/save")
	public String saveMember(@ModelAttribute("member") Member newMember, @RequestParam("program") int programId) {
		// retrieve program_id ....na to ksanadw pali
		//Program program = this.programRepository.findById(newMember.getProgram()).orElseThrow(() -> new IllegalArgumentException("Invalid program ID"));
		//this.memberRepository.save(newMember);
	    Program program = programRepository.findById(programId).orElseThrow(() -> new IllegalArgumentException("Invalid program id: " + programId));
	  
		newMember.setProgram(program);
		//save changes to repository
		this.memberRepository.save(newMember);
		return "redirect:/members";
	}

	
	/*
	 * Delete member from DB
	 */
	/*@RequestMapping(value = "/members/delete/{id}", method = RequestMethod.GET)
	public String deleteMember(@PathVariable("id") int id) {
	    // Find the member by id
	    Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id));

	    // Delete the member from the repository
	    member.setProgram(null);
	    
	    memberRepository.delete(member);
	    return "redirect:/members/listOfMembers";
	}*/
	@GetMapping("/members/delete/{id}")
	public String deleteMember(@PathVariable("id") int id) {

	    Member member = this.memberRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid member ID: " + id));
	    
	    //this.programRepository.delete(member.getProgram()); svhnei-den apodesmeuei olo to program...na to dw ksana
	    // to thetw null..
	    member.setProgram(null);

	    // delete member from database
	    this.memberRepository.delete(member);

	    return "redirect:/members/listOfMembers";
	}
	
	/*@RequestMapping(value="/members/delete{id}", method=RequestMethod.GET)
	public String deleteMember(@RequestParam("memberId") int theId) {
		
		Member member = this.memberRepository.findById(theId).orElseThrow();
		Program program = member.getProgram();
		memberRepository.deleteById(theId);
		//programRepository.deleteById(program.getId());
		//this.programRepository.delete((this.memberRepository.findById(theId)))
		//List<Member> members = this.memberRepository.findAll();
		//model.addAttribute("Members",members);
		return "redirect:/members/listOfMembers";
	}*/
	
	
	/*
	 * Update  for member
	 * public String updateMember(@RequestParam("memberId") int theId, Model model)
	 * */
	@RequestMapping("/members/updatemember")
	public String updateMember(@RequestParam("memberId") int theId,Model model) {
	
		model.addAttribute("member",memberRepository.findById(theId).orElse(null));
		model.addAttribute("programs",this.programRepository.findAll());
		return "addmember";
	}
	
	
	/*
	 * Display All Members from db
	 */
	@GetMapping("/members/listOfMembers")
	public String getAllMembers(Model model) {
		List<Member> members = this.memberRepository.findAll();
		model.addAttribute("Members",members);
		
		return "listOfMembers";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws ServletException {
	    request.logout();
	    return "redirect:/login?logout";
	}
	/*@RequestMapping("/members/setprogram")
	public String setProgram(@RequestParam("memberId") int theId) {
		return "setProgram";
	}*/
	
	/*
	 * Set or Update program plan for member
	 * */
	/*@RequestMapping("/members/set_update_program")
	public String setUpdateProgram(@RequestParam("memberId") int theId, Model model) {
		model.addAttribute("memberNewProgram", this.memberRepository.findById(theId));
		return "setOrUpdateProgram";
	}*/
	

	
	/*@GetMapping("/members/listOfMembers")
	public ResponseEntity getAllProducts() {
		return ResponseEntity.ok(this.memberRepository.findAll());
	}*/
	
}