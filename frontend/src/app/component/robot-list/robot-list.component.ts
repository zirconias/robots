import {Component, OnInit} from "@angular/core";
import {RobotService} from "../../service/robot.service";

@Component({
  selector: 'app-robot-list',
  templateUrl: './robot-list.component.html',
  styleUrls: ['./robot-list.component.css'],
  providers: []
})
export class RobotListComponent implements OnInit {
  public robots: Array<any>;

  constructor(private robotService: RobotService) {
  }

  ngOnInit() {
    this.robotService.getAll().subscribe(
      data => {
        this.robots = data;
      },
      error => {
        console.error('error ', error)
      }
    );
  }

}
