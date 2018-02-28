import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { CounselorHomePage } from '../counselor/home/home';
import { InqFormPersonalPage } from '../visitor/inq-form-personal/inq-form-personal';

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
    this.navCtrl.setRoot(InqFormPersonalPage);
  }
  toggleLogin(){
    this.isLogin = !this.isLogin;
  }
}
