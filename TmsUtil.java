package com.fedex.breco.insurance.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@Component
public class TmsUtil {
	private Logger logger = LoggerFactory.getLogger(TmsUtil.class);
	
	@Value("${com.fedex.sftp.host}")
	String SFTPHOST;
	@Value("${com.fedex.sftp.port}")
    int SFTPPORT ;
	@Value("${com.fedex.sftp.user}")
    String SFTPUSER;
	@Value("${com.fedex.sftp.pass}")
    String SFTPPASS;
	@Value("${com.fedex.sftp.dir}")
    String SFTPWORKINGDIR;
    
	public void sendFile(ByteArrayInputStream bInput , String filePath) {
		Session session = null;
	    Channel channel = null;
	    ChannelSftp channelSftp = null;
	    try {
	        JSch jsch = new JSch();
	        session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
	        session.setPassword(SFTPPASS);
	        java.util.Properties config = new java.util.Properties();
	        config.put("StrictHostKeyChecking", "no");
	        session.setConfig(config);
	        session.connect();
	        logger.info("Host connected.");
	        channel = session.openChannel("sftp");
	        channel.connect();
	        logger.info("sftp channel opened and connected.");
	        channelSftp = (ChannelSftp) channel;
	        channelSftp.cd(SFTPWORKINGDIR);
	        channelSftp.put(bInput, filePath);
	        logger.info("File transfered successfully to host.");
	    } catch (Exception ex) {
	    	logger.info("Exception found while tranfer the response.");
	        ex.printStackTrace();
	    } finally {
	        channelSftp.exit();
	        logger.info("sftp Channel exited.");
	        channel.disconnect();
	        logger.debug("Channel disconnected.");
	        session.disconnect();
	        logger.info("Host Session disconnected.");
	    }
	}
	
	public List<String> getFileNames(String path) {
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		List<String> filelists = new ArrayList<>();

		try {
			JSch jsch = new JSch();
			session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
			session.setPassword(SFTPPASS);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			logger.info("Host connected.");
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(path);
			Vector filelist = channelSftp.ls(path);
			for (int i = 0; i < filelist.size(); i++) {
				filelists.add(filelist.get(i).toString());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.info("filelists =" + filelists);
		return filelists;
	}

	public String getFileContent(String fileName, String path) {
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		List<String> filelists = new ArrayList<>();
		String data="";
		try {
			JSch jsch = new JSch();
			session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
			session.setPassword(SFTPPASS);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			logger.info("Host connected.");
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(path);
			Vector filelist = channelSftp.ls(path);
			for (int i = 0; i < filelist.size(); i++) {
				logger.info(fileName +"----"+ filelist.get(i).toString());
				if(filelist.get(i).toString().contains(fileName)) {
					logger.info("Match found");
					 InputStream stream = channelSftp.get(path + fileName);
					 
					 InputStreamReader isReader = new InputStreamReader(stream);
				      //Creating a BufferedReader object
				      BufferedReader reader = new BufferedReader(isReader);
				      StringBuffer sb = new StringBuffer();
				      String str;
				      while((str = reader.readLine())!= null){
				         sb.append(str).append("\r\n");
				      }
				      logger.info(sb.toString());
				      
					 data = sb.toString();
					 break;
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.info("filelists =" + filelists);
		return data;
	}
}
