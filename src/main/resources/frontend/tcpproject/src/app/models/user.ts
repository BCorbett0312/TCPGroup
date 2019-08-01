import {Channel} from "./channel";
import {Subscription} from "./subscription";

export class User{
  id: number;
  username: string;
  password: string;
  subscriptions: Subscription[];
  channels: Channel[];


  constructor(){
    this.password = null;
    // this.channels = ;

  }

}
