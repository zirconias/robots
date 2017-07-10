import {Component, EventEmitter, Input, OnInit, Output} from "@angular/core";

@Component({
  selector: 'app-robot-card',
  templateUrl: './robot-card.component.html',
  styleUrls: ['./robot-card.component.scss']
})
export class RobotCardComponent implements OnInit {

  @Input() productId: string;
  @Input() description: string;
  @Input() imageUrl: string;
  @Input() price: string;

  constructor() {
  }

  @Output() robotClick: EventEmitter<any> = new EventEmitter();

  ngOnInit() {
  }

  onButtonClick() {
    this.robotClick.next(this.price);
  }

}
