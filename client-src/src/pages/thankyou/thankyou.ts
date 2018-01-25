import { ViewChild, Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { HomePage } from '../../pages/home/home';
import { InqForm1Page } from '../../pages/inq-form1/inq-form1';

@Component({
  selector: 'page-thankyou',
  templateUrl: 'thankyou.html',
})
export class ThankyouPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ThankyouPage');
  }

  goToHome() {
    this.navCtrl.setRoot(HomePage);
  }
  newInquiry() {
    this.navCtrl.setRoot(InqForm1Page);
  }

}
