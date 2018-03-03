import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { HelperProvider } from '../../../providers/helper/helper';
import { InqDetailsPage } from '../inq-details/inq-details';
import { InqProvider } from '../../../providers/inq/inq';

@Component({
  selector: 'page-counselor-dashboard',
  templateUrl: 'home.html'
})
export class CounselorDashboardPage {

  private activeMenu: string = "counselor";
  private responseData;
  private unattendedInq;

  constructor(public navCtrl: NavController, private inqProvider: InqProvider, private helper: HelperProvider) {
    this.helper.setActiveMenu(this.activeMenu);
    this.getUnattendedInq();
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

}
