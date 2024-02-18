import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { HomePageComponent } from './home-page/home-page.component';
import { FormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import { CalendarModule} from 'angular-calendar';
import { MeniuComponent } from './meniu/meniu.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


const routes: Routes = [
  { path : 'costumers', component: CustomerComponent },
  { path: 'rezervation', component: CreateCustomerComponent },
  { path: 'homePage', component: HomePageComponent },
  {path:'meniu',component: MeniuComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    CreateCustomerComponent,
    HomePageComponent,
    MeniuComponent,
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    BrowserModule,
    CalendarModule,
    NgbModule
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
