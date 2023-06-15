package org.example.app.controllers;

import org.example.app.entities.Client;
import org.example.app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/list")
    public String getUsers(Model model) {
        List<Client> clients = service.getClients();
        model.addAttribute("clients", clients);
        return "clients-list";
    }

    @GetMapping("/showForm")
    public String showFormToAdd(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "client-form";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client) {
        service.saveClient(client);
        return "redirect:/clients/list";
    }

    @GetMapping("/updateForm")
    public String showFormToUpdate(@RequestParam("clientId") int id,
                                   Model model) {
        Client client = service.getClient(id);
        model.addAttribute("client", client);
        return "client-form";
    }

    @GetMapping("/delete")
    public String deleteClient(@RequestParam("clientId") int id) {
        service.deleteClient(id);
        return "redirect:/clients/list";
    }
}
