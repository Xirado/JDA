/*
 * Copyright 2015 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dv8tion.jda.api.events.interaction.command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GenericGuildEvent;
import net.dv8tion.jda.api.interactions.commands.privileges.IntegrationPrivilege;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

/**
 * Indicates that the {@link IntegrationPrivilege Privileges} of an application changed.
 * <br>If the moderator updates the privileges of a specific command, a {@link ApplicationCommandUpdatePrivilegesEvent} will be fired instead.
 *
 * <p>Can be used to get affected Guild and {@link List} of new {@link IntegrationPrivilege Privileges}
 */
public class ApplicationUpdatePrivilegesEvent extends GenericGuildEvent
{
    private final long applicationId;
    private final List<IntegrationPrivilege> privileges;

    public ApplicationUpdatePrivilegesEvent(@Nonnull JDA api, long responseNumber, @Nonnull Guild guild, long applicationId,
                                            @Nonnull List<IntegrationPrivilege> privileges)
    {
        super(api, responseNumber, guild);
        this.applicationId = applicationId;
        this.privileges = Collections.unmodifiableList(privileges);
    }

    /**
     * The new {@link IntegrationPrivilege Privileges} of the application.
     *
     * <p>If the moderator "Synced" the privileges of the application in question, this will be empty.
     *
     * @return Possibly empty unmodifiable list containing the new IntegrationPrivileges of the affected application.
     */
    @Nonnull
    public List<IntegrationPrivilege> getPrivileges()
    {
        return privileges;
    }

    /**
     * The id of the application in question.
     *
     * @return id of the application in question.
     */
    public long getApplicationIdLong()
    {
        return applicationId;
    }

    /**
     * The id of the application in question.
     *
     * @return id of the application in question.
     */
    @Nonnull
    public String getApplicationId()
    {
        return Long.toUnsignedString(applicationId);
    }
}
