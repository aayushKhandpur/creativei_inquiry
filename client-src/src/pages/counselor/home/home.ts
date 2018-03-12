import { Component } from '@angular/core';
import { NavController, ModalController } from 'ionic-angular';

import { HelperProvider } from '../../../providers/helper/helper';
import { InqDetailsPage } from '../inq-details/inq-details';
import { InqProvider } from '../../../providers/inq/inq';
import { ReminderProvider } from '../../../providers/reminder/reminder';
import { ReminderModalPage } from '../reminder-modal/reminder-modal';
import { NotificationProvider } from '../../../providers/notification/notification';
import { NotificationMessageProvider } from '../../../providers/notification-message/notification-message';

@Component({
  selector: 'page-counselor-home',
  templateUrl: 'home.html'
})
export class CounselorHomePage {

  private activeMenu: string = "counselor";
  private responseData;
  private unattendedInq;
  private todos;

  constructor(public navCtrl: NavController, private modalCtrl: ModalController, private inqProvider: InqProvider, private reminderProvider: ReminderProvider, private helper: HelperProvider, private notify: NotificationProvider, private message: NotificationMessageProvider) {
    this.helper.setActiveMenu(this.activeMenu);
    this.getUnattendedInq();
    this.getTodo();
  }

  createInq(){
    this.navCtrl.push(InqDetailsPage);
  }

  createTodo(data){
    this.reminderProvider.createReminder(data)
    .subscribe(
      data => {
        this.responseData = data;
        if(this.responseData.data){
          this.notify.showInfo("Reminder created successfully");
          console.log("Successfully created reminder, the response data is: ", data);
        }else if(this.responseData.exception){
          this.notify.showError("Could not create reminder");
          console.log("Error creating reminder, the response data is: ", data)
        }
      },
      error => {console.log("POST unsuccessful, the server returned this error:", error);},
      () => {console.log("COMPLETE");}
    );
  }

  getUnattendedInq(){
    this.inqProvider.getUnattendedInquiries()
    .subscribe(
      data => {this.responseData = data},
      error => {console.log("GET unsucessful, the server returned this error: ",error)},
      () => {
        this.unattendedInq = this.responseData.data;
        console.log("GET complete");
      }
    )
  }

  getTodo(){
    this.reminderProvider.getReminderForToday()
    .subscribe(
      data => {this.responseData = data},
      error => {console.log("GET unsucessful, the server returned this error: ",error)},
      () => {
        this.todos = this.responseData.data;
        console.log("GET complete");
      }
    )
  }

  showAddReminderModal(){
    let modal = this.modalCtrl.create(
      ReminderModalPage
    )
    modal.present();
    modal.onDidDismiss(data =>{
      if(data){
        console.log(data);
        this.createTodo(data);
      }
    });
  }

}
