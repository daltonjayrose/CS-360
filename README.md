# CS-360
<div align="center"><img src="https://i.imgur.com/2X53uwL.gif" alt="Example Image" width="270" height="600"></br>
Weight tracking application for Android</div>  

</br>  

**Briefly summarize the requirements and goals of the app you developed. What user needs was this app designed to address?**  
  
My application allows users to track their weight. This application was designed for users who are looking to gain weight, lose weight, or simply maintain their weight.  

  
**What screens and features were necessary to support user needs and produce a user-centered UI for the app? How did your UI designs keep users in mind? Why were your designs successful?**  
  
My application required a total of four screens: the login screen, the home screen, the add screen, and the settings screen. On the login screen, users needed to be able to login or create an account. On the home or log screen, users needed to be able to view past weight entries and delete entries. On the add screen, users needed to be able to add a new weight entry to the weight entry database. On the settings screen, users needed to be able to set a goal weight and provide a phone number for SMS updates. Overall, I kept my user interface relatively simple and used clear labeling to create a user interface that is easy to ready and intuitive to use.  

**How did you approach the process of coding your app? What techniques or strategies did you use? How could those techniques or strategies be applied in the future?**  
  
When I started coding my app, I knew I needed a few things. I need to code all the interactive elements like buttons. I knew I needed to have several different databases with basic CRUD functionality to manage data in those databases. I knew I needed to retrieve a list of all the database entries and display them on the home screen. For the most part, I was already familiar with many of these tasks. However, I did have to research a lot to learn exactly how to complete these tasks in Android. Breaking down larger concepts into smaller discrete tasks and figuring out how to complete those tasks is a very valuable skill which I utilized in this project. 

**How did you test to ensure your code was functional? Why is this process important, and what did it reveal?** 
  
Primarily, I manually tested the application with an Android Studio emulator. I paid attention to the error logs to monitor potential issues in the code. However, I did not perform sufficient testing overall. I have not tested the application yet on a real device and ideally I'd test it across multiple devices. I didn't design unit tests to test specific code functionality. While I didn't encounter many issues while working on this project, testing is important because there are so many different variables which could result in an issue occuring. While the stakes are low for a weight tracking application, errors in your code can sometimes have serious implications. It's important to thoroughly test your application to prevent major issues and ensure users have a good experience. 

**Consider the full app design and development process from initial planning to finalization. Where did you have to innovate to overcome a challenge?**  

  There were a few challenges I had to overcome during the completion of this project. I had no experience working with Android app development before CS-360, so there was a large learning curve from the beginning. Initially, I developed each screen as it's own activity. However, when I later wanted to add a bottom navigation bar, I decided to convert each activity to a fragment instead. At one point, I was going to use a RecyclerView for the main log page but ran into difficulties getting it to function correctly with the data from the database. I decided to change to a ListView later in the project as I was already running behind, though if I had more time, I'd have spent more time getting the RecyclerView to work.
  
**In what specific component of your mobile app were you particularly successful in demonstrating your knowledge, skills, and experience?**  

  While things didn't go entirely to plan, developing a complete (albeit simple) mobile application is an achievement. There are a lot of areas I could have done better in, but I think overall, I did a good job developing the required functionality, and creating an intuitive and easy to read user interface.
