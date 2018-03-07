import { Component } from '@angular/core';
import { NavController, NavParams, LoadingController } from 'ionic-angular';
import { TitleCasePipe } from '@angular/common';


import { InqProvider } from '../../../providers/inq/inq';

@Component({
  selector: 'page-inq-summary',
  templateUrl: 'inq-summary.html',
})
export class InqSummaryPage {

  private currentInq;
  private currentInqId;

  constructor(public navCtrl: NavController, public navParams: NavParams, private loadingCtrl: LoadingController, private inqProvider: InqProvider) {
    this.currentInqId = this.navParams.data;
    this.getCurrentInq();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad InqSummaryPage');
  }

  private loading;

  presentLoadingCustom() {
    this.loading = this.loadingCtrl.create({
      spinner: 'hide',
      content: `
        <img src="../../assets/imgs/loading.svg" />
      `
    });
    this.loading.onDidDismiss(() => {
      console.log('Dismissed loading');
    });

    this.loading.present();
  }

  getCurrentInq(){
    this.presentLoadingCustom();
    this.inqProvider.getInqById(this.currentInqId)
    .subscribe(
      data => {
        let responseData;
        responseData = data;
        this.currentInq = responseData.data;
        console.log("Inquiry to be viewed is: ",this.currentInq);
      },
      error => {
        console.log("GET unsuccessful, the server returned this error: ", error)
        this.loading.dismissAll();
      },
      () => {
        console.log("complete")
        this.loading.dismissAll();
      }
      
    );
  }

}
