/*
 * Copyright 2024 wts
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wts.tsrpcserverdemo.service;

import com.wts.tsrpc.demo.interfaces.params.Request;
import com.wts.tsrpc.demo.interfaces.params.Response;
import com.wts.tsrpc.demo.interfaces.params.SubResponse;
import com.wts.tsrpc.spring.config.annotation.TSService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TSService(serviceId = "providerService")
public class ProviderService {

    public String primitiveService(String arg1, String arg2) {
        return arg1 + ": " + arg2;
    }

    public Response complexService(Request request) {
        Response response = new Response();
        response.setArg1(request.getArg1() + "&");
        response.setArg2(request.getArg2() + 1);
        Map<String, List<SubResponse>> map = new HashMap<>();
        List<SubResponse> list = new ArrayList<>();
        list.add(new SubResponse("subRes1", "subRes2"));
        list.add(new SubResponse("subRes3", "subRes4"));
        map.put("key2", list);
        response.setArg3(map);
        return response;
    }
}
