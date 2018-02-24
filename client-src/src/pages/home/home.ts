import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { CounselorHomePage } from '../counselor/home/home';
import { InqForm1Page } from '../visitor/inq-form1/inq-form1';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  private isLogin: boolean = false;

  constructor(public navCtrl: NavController) {
  }

  goToCounselorDash(){
    this.navCtrl.setRoot(CounselorHomePage);
  }
  goToVisitorPage(){
    this.navCtrl.setRoot(InqForm1Page);
  }
  toggleLogin(){
    this.isLogin = !this.isLogin;
  }
}
