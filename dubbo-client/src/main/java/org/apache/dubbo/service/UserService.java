/**
 * Copyright(C) 2021 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package org.apache.dubbo.service;

import org.apache.dubbo.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author zhaoyunxing
 * @date: 2021-04-03 02:09
 */
@Path("users") // #1
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML}) // #2
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface UserService {


    @GET // #3
    @Path("{id: \\d+}")
    User getUser(@PathParam("id") String id);
}
