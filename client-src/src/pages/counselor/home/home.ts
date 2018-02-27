import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { HelperProvider } from '../../../providers/helper/helper';
import { InqDetailsPage } from '../inq-details/inq-details';

@Component({
  selector: 'page-counselor-home',
  templateUrl: 'home.html'
})
export class CounselorHomePage {

  private activeMenu: string = "counselor";

  constructor(public navCtrl: NavController, private helper: HelperProvider) {
    this.helper.setActiveMenu(this.activeMenu);
  }

  createInq(){
    this.navCtrl.push(InqDetailsPage);
  }

  createTodo(){
    //todo
  }

}
