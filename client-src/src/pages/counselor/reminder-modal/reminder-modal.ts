import { Component } from '@angular/core';
import { NavController, NavParams, ViewController } from 'ionic-angular';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';

import { ReminderProvider } from '../../../providers/reminder/reminder'

@Component({
  selector: 'page-reminder-modal',
  templateUrl: 'reminder-modal.html',
})
export class ReminderModalPage {

  private reminderForm: FormGroup

  today = new Date();
  minDate : String = this.today.getFullYear()+"-"+this.today.getMonth()+"-"+this.today.getDate();

  constructor(public navCtrl: NavController, public navParams: NavParams, private view: ViewController,private formBuilder: FormBuilder,private reminderProvider: ReminderProvider) {

    this.reminderForm = this.formBuilder.group({
      title: ['', Validators.required],
      description: [''],
      time: ['', Validators.required]
    });

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ReminderModalPage');
  }

  addReminder(){
    if(this.reminderForm.valid){
      console.log(this.reminderForm.value);
      this.view.dismiss(this.reminderForm.value);
    }
  }

  closeModal(){
    this.view.dismiss(null);
  }

}
