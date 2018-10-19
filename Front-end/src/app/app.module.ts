import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {DashboardComponent} from './view/dashboard/dashboard.component';
import {CarMainComponent} from './view/car-main/car-main.component';
import {NavBarComponent} from './view/nav-bar/nav-bar.component';
import {FooterComponent} from './view/footer/footer.component';
import {CustomerMainComponent} from './view/customer-main/customer-main.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

export const MAIN_URL = 'http://localhost:8080';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {path: 'dashboard', component: DashboardComponent},
  {path: 'customer_main', component: CustomerMainComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    CarMainComponent,
    NavBarComponent,
    FooterComponent,
    CustomerMainComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
    ),
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
