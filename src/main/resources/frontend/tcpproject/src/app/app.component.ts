import {Component, EventEmitter, Output} from '@angular/core';
import {User} from "./user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tcpproject';
  isLoggedIn = false;
  currentUser: User;
  @Output() userLoggedIn = new EventEmitter();
  compose = false;


  updateLogin(){
    if(this.isLoggedIn === false){
      this.isLoggedIn = true;
    } else{this.isLoggedIn = false}
  }

  setCurrentUser(user: User){
    this.currentUser = user;
  }

  login(user: User){
    this.updateLogin();
    this.setCurrentUser(user);

    this.userLoggedIn.emit();
  }
}

