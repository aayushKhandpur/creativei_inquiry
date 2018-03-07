import { Component } from '@angular/core';
import { NavController, NavParams, LoadingController } from 'ionic-angular';

import { InqProvider } from '../../../providers/inq/inq';
import { NotificationProvider } from '../../../providers/notification/notification';
import { NotificationMessageProvider } from '../../../providers/notification-message/notification-message';
import { InqDetailsPage } from '../inq-details/inq-details';
import { InqSummaryPage } from '../inq-summary/inq-summary';

@Component({
  selector: 'page-inq-list',
  templateUrl: 'inq-list.html',
})
export class InqListPage {

  private inquiries;
  private responseData;

  constructor(public navCtrl: NavController, public navParams: NavParams, private loadingCtrl: LoadingController, private inqProvider: InqProvider, private notify: NotificationProvider, private message: NotificationMessageProvider) {

    this.getAllInq();

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad InqListPage');
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

  getAllInq(){
    this.presentLoadingCustom();
    this.inqProvider.getAllInq()
      .subscribe(
        data => {
          this.responseData = data;
        },
        error => { console.log("GET unsucessful, the server returned this error:", error), this.loading.dismissAll(); },
        () => {
          console.log("complete");
          this.loading.dismissAll();
          this.inquiries = this.responseData.data;
        }
      )
  }

  editInq(id){
    this.navCtrl.push(InqDetailsPage,id);
  }
  
  viewInq(id){
    this.navCtrl.push(InqSummaryPage,id);
  }

  toggleSeeMore(i){
    this.inquiries[i].seeMore = !this.inquiries[i].seeMore;
  }

  filterInqByDate(from,to){
    this.inquiries = this.inquiries.filter(inq => inq.inquiryDate >= from && inq.inquiryDate <= to);
    console.log(this.inquiries);
  }

}
