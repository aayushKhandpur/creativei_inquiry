import { Component, ViewChild } from '@angular/core';
import { Nav, Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { InqProvider } from '../providers/inq/inq';
import { FollowUpProvider } from '../providers/follow-up/follow-up';

import { HomePage } from '../pages/home/home';
import { InqForm1Page } from '../pages/visitor/inq-form1/inq-form1';
import { CounselorHomePage } from '../pages/counselor/home/home';
import { InqDetailsPage } from '../pages/counselor/inq-details/inq-details';
import { InqListPage } from '../pages/counselor/inq-list/inq-list';
import { InqSummaryPage } from '../pages/counselor/inq-summary/inq-summary';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage: any = HomePage;

  visitorPages: Array<{title: string, component: any}>;
  counselorPages: Array<{title: string, component: any}>;

  constructor(public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen, private inqProvider: InqProvider, private followUpProvider: FollowUpProvider) {
    this.initializeApp();

    // used for an example of ngFor and navigation
    this.visitorPages = [
      { title: 'Home', component: HomePage },
    ];
    this.counselorPages = [
      { title: 'Home', component: CounselorHomePage},
      { title: 'View Inquiries', component: InqListPage},
      { title: 'Reports', component: InqSummaryPage},
      { title: 'Logout', component: HomePage}
    ];

  }

  initializeApp() {
    this.platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      this.statusBar.styleDefault();
      this.splashScreen.hide();
      //Getting all the enum values for the application here
      this.inqProvider.getEnums();
      this.followUpProvider.getEnums();

    });
  }

  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
    this.nav.setRoot(page.component);
  }
}
