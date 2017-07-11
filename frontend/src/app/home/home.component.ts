import {Component, OnInit} from "@angular/core";
import {RobotsService} from "../service/robots.service";
import {Headers, RequestOptions} from "@angular/http";
import {RobotCardComponent} from "../component/robot-card/robot-card.component";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public robots: Array<RobotCardComponent>;

  constructor(private robotsService: RobotsService) {
  }

  ngOnInit() {
    this.getRobots();
  }

  getRobots() {
    let headers = new Headers({
      'Accept': 'application/json'
    });
    let options = new RequestOptions({headers: headers, withCredentials: true});
    this.robotsService.getRobots().subscribe(
      res => {
        this.robots = res;
      }
    );
  }

}
