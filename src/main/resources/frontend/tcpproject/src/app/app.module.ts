import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MessageComposeComponent } from './message-compose/message-compose.component';
import { MessageListComponent } from './message-list/message-list.component';
import {MessageService} from "./services/messageService";
import {ChannelService} from "./services/channelService";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { ChannellisttopComponent } from './channellisttop/channellisttop.component';
import { UserlistComponent } from './userlist/userlist.component';
import { LoginbarComponent } from './loginbar/loginbar.component';
import {UserService} from "./services/userService";

@NgModule({
  declarations: [
    AppComponent,
    MessageComposeComponent,
    MessageListComponent,
    ChannellisttopComponent,
    UserlistComponent,
    LoginbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [MessageService, ChannelService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
