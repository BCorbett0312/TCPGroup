export class EnvService {

  // The values that are defined here are the default values that can
  // be overridden by env.js

  // API url
  public apiUrl = 'http://localhost:8080'; // 'https://teamac.herokuapp.com'; //

  // Whether or not to enable debug mode
  public enableDebug = true;

  constructor() {
  }

}
