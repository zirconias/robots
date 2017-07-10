import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
// material
import {MaterialModule, MdIconRegistry} from "@angular/material";
// different theme
import "style-loader!@angular/material/prebuilt-themes/pink-bluegrey.css";
import {FlexLayoutModule} from "@angular/flex-layout";

import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app-routing.module";
import {HomeComponent} from "./home";
import {LoginComponent} from "./login";

import {LoginGuard} from "./guard";
import {NotFoundComponent} from "./not-found";
import {FooterComponent, HeaderComponent, RobotCardComponent, RobotListComponent} from "./component";

import {ApiService, AuthService, ConfigService, RobotService,
  RobotsService,
  UserService
} from "./service";

import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
// import 'style-loader!@angular/material/prebuilt-themes/deeppurple-amber.css';
// import 'style-loader!@angular/material/prebuilt-themes/indigo-pink.css';
// import 'style-loader!@angular/material/prebuilt-themes/purple-green.css';


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
    FlexLayoutModule,
    BrowserAnimationsModule
  ],
  providers: [
    RobotService,
    RobotsService,
    AuthService,
    ApiService,
    UserService,
    ConfigService,
    LoginGuard,
    MdIconRegistry
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
