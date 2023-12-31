package com.movies.movieservice.controller;


import com.movies.movieservice.model.FriendRequest;
import com.movies.movieservice.model.User;
import com.movies.movieservice.service.FriendService;
import com.movies.movieservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("friends")
@Controller
public class FriendController {
    @Autowired
    private UserService userService;
    @Autowired
    private FriendService friendService;

    @GetMapping("/friendList")
    public String friendsList(Model model) {
        model.addAttribute("profiles", friendService.friendList());
        return "friendList";
    }

    @GetMapping("/findUserByUsernameSubstring")
    public String findUsersByUsername(Model model, String usernameSubstring) {
        model.addAttribute("profiles", userService.findUsersByUsernameSubstring(usernameSubstring));
        return "friendList";
    }

    @PostMapping("/sendFriendRequest")
    public String sendFriendRequest(@RequestParam User recipient) {
        friendService.sendFriendRequest(recipient);
        return "redirect:/friends/friendList";
    }

    @PostMapping("/acceptFriendRequest")
    public String acceptFriendRequest(@RequestParam FriendRequest friendRequest) {
        friendService.acceptFriendRequest(friendRequest);
        return "redirect:/friends/friendList";
    }

    @PostMapping("/rejectFriendRequest")
    public String rejectFriendRequest(@RequestParam FriendRequest friendRequest) {
        friendService.rejectFriendRequest(friendRequest);
        return "redirect:/friends/friendList";
    }

    @GetMapping("/getUserFriendRequests")
    public String getUserFriendRequests(Model model) {
        model.addAttribute("friendRequests", friendService.getUserFriendRequests());
        return "friendRequests";
    }
    @GetMapping("/getOutputFriendRequests")
    public String getOutputFriendRequest(Model model){
        model.addAttribute("friendRequests",friendService.getOutputFriendRequest());
        return "friendRequests";
    }
}
