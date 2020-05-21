package com.spring.controller;

import com.spring.model.Client;
import com.spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        List<Client> listClient = clientService.getAll();
        model.addAttribute("listClient", listClient);
        return "index";
    }

    @RequestMapping("/new")
    public String newClientForm(Map<String, Object> model) {
        Client client = new Client();
        model.put("client", client);
        return "new_client";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.save(client);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public String editClientForm(@RequestParam Long id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "edit_client";
    }
    @RequestMapping("/delete")
    public String deleteClientForm(@RequestParam Long id) {
        clientService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String string, Model model) {
        List<Client> result = clientService.search(string);
        model.addAttribute("result", result);
        return "search";
    }
}
