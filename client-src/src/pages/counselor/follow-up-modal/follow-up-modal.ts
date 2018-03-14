import { Component } from '@angular/core';
import { NavController, NavParams, ViewController } from 'ionic-angular';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';

import { FollowUpProvider } from '../../../providers/follow-up/follow-up'

@Component({
  selector: 'page-follow-up-modal',
  templateUrl: 'follow-up-modal.html',
})
export class FollowUpModalPage {

  private enums;
  private followUpStatus;
  private subStatus;
  private followUpType;
  private caseIndex;

  private followUpForm: FormGroup

  constructor(public navCtrl: NavController, public navParams: NavParams, private view: ViewController,private formBuilder: FormBuilder,private followUpProvider: FollowUpProvider) {

    this.followUpForm = this.formBuilder.group({
      followUpType: ['', Validators.required],
      followUpStatus: ['', Validators.required],
      remark: [''],
      caseIndex: ['', Validators.required],
      subStatus: ['', Validators.required]
    });

    this.setEnums();
    this.setFollowUpStatus();
    this.setSubStatus();
    this.setFollowUpType();
    this.setCaseIndex();

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad FollowUpModalPage');
  }

  closeInquiry(){
    if(this.followUpForm.valid){
      console.log(this.followUpForm.value);
      this.view.dismiss(this.followUpForm.value);
    }
  }

  closeModal(){
    this.view.dismiss(null);
  }
  
  setEnums(){
    this.enums = this.followUpProvider.getEnums();
  }
  setFollowUpStatus(){
    this.followUpStatus = this.enums.data.followUpStatus;
  }
  setSubStatus(){
    this.subStatus = this.enums.data.followUpSubStatus;
  }
  setFollowUpType(){
    this.followUpType = this.enums.data.followUpType;
  }
  setCaseIndex(){
    // this.caseIndex = this.enums.data.caseIndex;
    this.caseIndex =  [
			{"index":1,"value":"Unlikely"},
			{"index":2,"value":"Intersted"},
			{"index":3,"value":"Likely"},
			{"index":4,"value":"Hot Lead"}
		]
  }
}
