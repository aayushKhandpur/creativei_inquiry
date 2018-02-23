import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { Ng2CompleterModule } from "ng2-completer";

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { InqForm1Page } from '../pages/visitor/inq-form1/inq-form1';
import { InqForm2Page } from '../pages/visitor/inq-form2/inq-form2';
import { InqForm3Page } from '../pages/visitor/inq-form3/inq-form3';
import { ThankyouPage } from '../pages/visitor/thankyou/thankyou';
import { CounselorHomePage } from '../pages/counselor/home/home';
import { InqDetailsPage } from '../pages/counselor/inq-details/inq-details';
import { InqListPage } from '../pages/counselor/inq-list/inq-list';
import { InqSummaryPage } from '../pages/counselor/inq-summary/inq-summary';
import { InqCloseModalPage } from '../pages/counselor/inq-close-modal/inq-close-modal';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { InqProvider } from '../providers/inq/inq';
import { NotificationProvider } from '../providers/notification/notification';
import { LocalityProvider } from '../providers/locality/locality';
import { NotificationMessageProvider } from '../providers/notification-message/notification-message';
import { HelperProvider } from '../providers/helper/helper';
import { FollowUpProvider } from '../providers/follow-up/follow-up';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    InqForm1Page,
    InqForm2Page,
    InqForm3Page,
    InqDetailsPage,
    InqListPage,
    InqSummaryPage,
    ThankyouPage,
    InqCloseModalPage,
    CounselorHomePage
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    Ng2CompleterModule,
    IonicModule.forRoot(MyApp),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    InqForm1Page,
    InqForm2Page,
    InqForm3Page,
    InqDetailsPage,
    InqListPage,
    InqSummaryPage,
    ThankyouPage,
    InqCloseModalPage,
    CounselorHomePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    InqProvider,
    NotificationProvider,
    LocalityProvider,
    NotificationMessageProvider,
    HelperProvider,
    FollowUpProvider
  ]
})
export class AppModule {}
