package com.hotmail.a_asultan.Inlamningsuppgift1;


import com.hotmail.a_asultan.LogginProject.Service;

import java.util.logging.Logger;


public class InputCommando {
    private static final Logger log = Logger.getLogger(Service.class.getName());

    public String testCommando(String[] inputData) {
        String commando = inputData[0];

        switch (commando) {
            case "add":
                if (inputData.length == 4) {
                    return commando;
                } else
                    return "Input parameters with (add) commando should be (three)";

            case "list":
                if (inputData.length == 1) {
                    return commando;
                } else
                    return "No Input parameters should be with (list) commando";

            case "search":
                if (inputData.length == 2) {
                    return commando;
                } else return "Input parameters with (search) commando should be (one)";

            case "help":
                if (inputData.length == 1) {
                    return commando;
                } else return "No Input parameters should be with (help) commando";

            case "delete":
                if (inputData.length == 2) {
                    return commando;
                } else
                    return "Input parameters with (delete) commando should be (one)";

            case "quit":
                if (inputData.length == 1) {
                    return commando;
                } else return "No Input parameters should be with (quit) commando";

            default: {
                return commando;
            }
        }
    }
}

