import discord
import os
import mysql.connector
import aiomysql
import asyncio
from dotenv import load_dotenv

# Permissions
intents = discord.Intents.default()
intents.typing = False
intents.presences = False
intents.message_content = True

client = discord.Client(intents=intents)

# Loading .env File
load_dotenv()

# Configuring MySQL
db_config = {
    "host": os.getenv('HOST'),
    "user": os.getenv('USER'),
    "password": os.getenv('PASSWORD'),
    "database": os.getenv('DATABASE'),
}

async def check_database_for_updates():
    while True:
        await asyncio.sleep(300) 

        try:
            connection = await aiomysql.connect(**db_config, autocommit=True)
            cursor = await connection.cursor()
            
            cursor.close()
            connection.close()
        except Exception as e:
            print(f"Error checking the database: {e}")

# Words of Commands asked
sig_words = [
    "sig", "groups", "interestgroups", "wecsigs", "specialinterestgroups",
    "interestgroups", "group"
]
members_words = ["members", "people", "ppl", "team", "seniors"]
upevents_words = [
    "upcommingevents", "newevents", "commingevents", "nextevents", "curr",
    "current"
]
pevents_words = [
    "oldevents", "previousevents", "pastevents", "prevevents",
    "doneevents", "prev","previouslyheld"
]
con = [
    "who is the convenor of the web club", "whoistheconvenorofthewebclub",
    "con", "convenor"
]
comeve = ["whatistheupcomming event", "commingupnext"]
thanks_words = ["thank you", "thanks", "appreciate ", "gratitude", "thankyou"]

@client.event
async def on_ready():
  print(f"Logged in as {client.user}")

# This is the main function used here for all the commands
@client.event
async def on_message(message):  
  if message.author == client.user:
    return

  msg = message.content.lower().replace(" ", "")

  if msg.startswith("/hello"):
    await message.channel.send("Hello! Welcome to this server. I am Info Bot, and I am here to help you with your queries related to WEC NITK.")

  if msg.startswith(".wec"):
    if any(word in msg for word in sig_words):
      # Retrieve values from the database
      conn = mysql.connector.connect(**db_config)
      cursor = conn.cursor()
      cursor.execute("SELECT * FROM sig")
      values = cursor.fetchall()
      cursor.close()
      conn.close()
      values_str = '\n\n'.join(str(value[0]) for value in values)
      await message.channel.send(f"Sigs! Sure, here you go:\n\nWEC NITK has 4 SIGs:\n{values_str}")

  if msg.startswith(".wec"):
    if any(word in msg for word in members_words):
      conn = mysql.connector.connect(**db_config)
      cursor = conn.cursor()
      cursor.execute("SELECT Name FROM members where Position = 'Core'")
      values = cursor.fetchall()
      values_str = '\n'.join(str(value[0]) for value in values)
      await message.channel.send(f"The Core of WEC NitK for year 2023-2024:\n{values_str}")

      cursor.execute("SELECT Name FROM membersaldo where Grp = 'Algorithms'")
      values = cursor.fetchall()
      values_str = '\n'.join(str(value[0]) for value in values)
      await message.channel.send(f"Members of Algorithm sig:\n{values_str}")

      cursor.execute("SELECT Name FROM membersgdsc where grp = 'GDSC'")
      values = cursor.fetchall()
      values_str = '\n'.join(str(value[0]) for value in values)
      await message.channel.send(f"Members of Google Development Students Club sig:\n{values_str}")

      cursor.execute("SELECT Name FROM membersintel where grp = 'Intelligence'")
      values = cursor.fetchall()
      values_str = '\n'.join(str(value[0]) for value in values)
      await message.channel.send(f"Members of Intelligence sig:\n{values_str}")

      cursor.execute("SELECT Name FROM memberssys where grp = 'Systems'")
      values = cursor.fetchall()
      values_str = '\n'.join(str(value[0]) for value in values)
      await message.channel.send(f"Members of Systems sig:\n{values_str}")

      cursor.close()
      conn.close()

  if msg.startswith(".wec"):
    if any(word in msg for word in upevents_words):
      conn = mysql.connector.connect(**db_config)
      cursor = conn.cursor()
      cursor.execute("SELECT * FROM upevents")
      values = cursor.fetchall()
      values_str = '\n'.join(str(value[0]) for value in values)
      length = len(values_str)

      if length == 0:
        await message.channel.send("No Upcoming events currently. :(")
      else:
        await message.channel.send(f"The Upcoming events of WEC are:\n{values_str}")

      cursor.close()
      conn.close()

  if msg.startswith(".wec"):
    if any(word in msg for word in pevents_words):
      conn = mysql.connector.connect(**db_config)
      cursor = conn.cursor()
      cursor.execute("SELECT * FROM pevents")
      values = cursor.fetchall()
      values_str = '\n'.join(str(value[0]) for value in values)
      await message.channel.send(f"The Past events of WEC are:\n{values_str}")

      cursor.close()
      conn.close()

  if msg.startswith(".wec"):
    if any(word in msg for word in con):
      conn = mysql.connector.connect(**db_config)
      cursor = conn.cursor()
      cursor.execute("SELECT * FROM con")
      values = cursor.fetchall()
      values_str = '\n'.join(str(value[0]) for value in values)
      await message.channel.send(f"The Convenor of the Web club is - {values_str}")

      cursor.close()
      conn.close()

  if msg.startswith(".wec"):
    if any(word in msg for word in comeve):
      conn = mysql.connector.connect(**db_config)
      cursor = conn.cursor()
      cursor.execute("SELECT * FROM upevents")
      values = cursor.fetchall()
      values_str = '\n'.join(str(value[0]) for value in values)
      length = len(values_str)

      if length == 0:
        await message.channel.send("No Upcoming events currently. :(")
      else:
        await message.channel.send(f"The Upcoming events of WEC are:\n{values_str}")

      cursor.close()
      conn.close()

  if msg.startswith(".wec"):
    if any(word in msg for word in thanks_words):
      await message.channel.send("I am glad to hear that you liked it. I have provided the best information available to me.")

# Runs Token
client.run(os.getenv('TOKEN'))

