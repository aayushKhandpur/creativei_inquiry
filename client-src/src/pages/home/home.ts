import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { InqProvider } from '../../providers/inq/inq';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController, private inqProvider: InqProvider) {
    this.inqProvider.getEnums();
  }

}
