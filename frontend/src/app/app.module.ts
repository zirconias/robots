import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
// material
import { MaterialModule, MdIconRegistry } from '@angular/material';
// different theme
import 'style-loader!@angular/material/prebuilt-themes/pink-bluegrey.css';
// import 'style-loader!@angular/material/prebuilt-themes/deeppurple-amber.css';
// import 'style-loader!@angular/material/prebuilt-themes/indigo-pink.css';
// import 'style-loader!@angular/material/prebuilt-themes/purple-green.css';

import { FlexLayoutModule } from '@angular/flex-layout';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home';
import { LoginComponent } from './login';

import { LoginGuard } from './guard';
import { NotFoundComponent } from './not-found';
import {
  HeaderComponent,
  RobotCardComponent,
  RobotListComponent,
  FooterComponent
} from './component';
import {RobotService} from "./service/robot.service";


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    RobotCardComponent,
    RobotListComponent,
    HomeComponent,
    LoginComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
    MaterialModule,
    FlexLayoutModule
  ],
  providers: [
    RobotService,
    LoginGuard,
    MdIconRegistry
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
