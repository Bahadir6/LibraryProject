import { MemberService } from './member.service';
import { Member } from './member';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {

  public members: Member[] = [];

  constructor(private memberService: MemberService) { }

  ngOnInit(): void {
    this.getMembers();
  }

  public getMembers(): void {
    this.memberService.getMembers().subscribe(
      (response: Member[]) => {
        this.members=response;
        console.log(this.members);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddMember(addForm: NgForm ): void {
    document.getElementById('add-member-form')!.click();
    this.memberService.addMember(addForm.value).subscribe(
      (response: Member) => {
        console.log(response);
        this.getMembers();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

 
  public onOpenModal(member: Member | null,mode:string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type ='button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    if(mode==='add'){
      button.setAttribute('data-target','#addMemberModal');
    }
    if(mode==='edit'){
      button.setAttribute('data-target','#updateMemberModal');
    }
    if(mode==='delete'){
      button.setAttribute('data-target','#deleteMemberModal');
    }
    container?.appendChild(button);
    button.click();

  }


}

