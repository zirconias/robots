import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";

import {AppComponent} from "./app.component";
import {RobotListComponent} from "./component/robot-list/robot-list.component";
import {RobotService} from "./service/robot.service";
import {HttpModule} from "@angular/http";

@NgModule({
  declarations: [
    AppComponent,
    RobotListComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [RobotService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
