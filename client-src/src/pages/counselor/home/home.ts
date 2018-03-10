import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { HelperProvider } from '../../../providers/helper/helper';
import { InqDetailsPage } from '../inq-details/inq-details';
import { InqProvider } from '../../../providers/inq/inq';
import { ReminderProvider } from '../../../providers/reminder/reminder';

@Component({
  selector: 'page-counselor-dashboard',
  templateUrl: 'home.html'
})
export class CounselorDashboardPage {

  private activeMenu: string = "counselor";
  private responseData;
  private unattendedInq;
  private inqStats;
  private todos;

  today = Date.now();

  constructor(public navCtrl: NavController, private inqProvider: InqProvider, private reminderProvider: ReminderProvider, private helper: HelperProvider) {
    this.helper.setActiveMenu(this.activeMenu);
    this.getUnattendedInq();
    this.getInqStats();
    this.getTodo();
  }

  createInq(){
    this.navCtrl.push(InqDetailsPage);
  }

  createTodo(){
    //todo
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

  getInqStats(){
    this.inqProvider.getInquiryStats()
    .subscribe(
      data => {this.responseData = data},
      error => {console.log("GET unsucessful, the server returned this error: ",error)},
      () => {
        this.inqStats = this.responseData.data;
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

}
