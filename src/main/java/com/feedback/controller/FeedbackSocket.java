package com.feedback.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.feedback.entity.Feedback;

import java.util.logging.Logger;

@ServerEndpoint("/newFeedback")
public class FeedbackSocket {
	private static final Logger LOG = Logger.getLogger(Feedback.class.getName());
	private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public Feedback onMessage() {
		Feedback feedback = new Feedback();
		feedback.setComment("Test");
		return feedback;
	}

	@OnOpen
	public void onOpen(Session peer) {
		LOG.info("Connection opened ...");
		peers.add(peer);
	}

	@OnClose
	public void onClose(Session peer) {
		LOG.info("Connection closed ...");
		peers.remove(peer);
	}
}
